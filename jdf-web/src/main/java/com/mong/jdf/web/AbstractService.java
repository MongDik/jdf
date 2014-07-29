/* 
 * @(#)AbstractService.java    Created on 2014-7-23
 * Copyright (c) 2014 Guomi. All rights reserved.
 */
package com.mong.jdf.web;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractService.class);
    
    public String marshal(Object value){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(value);
        } catch (JsonGenerationException e) {
            LOGGER.error(e.getMessage());
        } catch (JsonMappingException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return "";
    }
    
    public Object unmarshal(){
//        TODO
        return null;
    }
}
