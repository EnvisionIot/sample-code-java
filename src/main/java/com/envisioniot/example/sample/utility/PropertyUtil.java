/**
 * Copyright (C), 2015-2021, Envision
 * FileName: PropertyUtil
 * Author:   xibin.song
 * Date:     11/30/2021 1:49 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.envisioniot.example.sample.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author xibin.song
 * @create 11/30/2021
 * @since 1.0.0
 */

public class PropertyUtil {
    private Properties properties;

    public PropertyUtil(String propertyFileName) throws IOException {
        InputStream is = getClass().getClassLoader()
                .getResourceAsStream(propertyFileName);
        this.properties = new Properties();
        this.properties.load(is);
    }

    public String getProperty(String propertyName) {
        return this.properties.getProperty(propertyName);
    }
}
