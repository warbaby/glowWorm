/*
 * Copyright 1999-2101 Alibaba Group.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jd.glowworm.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

import com.jd.glowworm.PB;

/**
 * @author wenshao<szujobs@hotmail.com>
 */
public class StringSerializer implements ObjectSerializer {

    public static StringSerializer instance = new StringSerializer();

    public void write(PBSerializer serializer, Object object, Object fieldName, Type fieldType) throws IOException {
        write(serializer, (String) object, fieldName);
    }

    public void write(PBSerializer serializer, String value, Object fieldName) {
        SerializeWriter out = serializer.getWriter();
        if (fieldName == null)
        {
        	out.getCodedOutputStream().writeRawByte(com.jd.glowworm.asm.Type.STRING);
        }
        out.getCodedOutputStream().writeString(value);
    }
}
