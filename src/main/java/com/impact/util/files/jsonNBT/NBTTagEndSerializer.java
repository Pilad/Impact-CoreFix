/*
 *  Copyright (c) 2014, Lukas Tenbrink.
 *  * http://lukas.axxim.net
 */

package com.impact.util.files.jsonNBT;

import com.google.gson.*;
import net.minecraft.nbt.NBTTagEnd;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

/**
 * Created by lukas on 25.05.14.
 */
public class NBTTagEndSerializer implements JsonSerializer<NBTTagEnd>, JsonDeserializer<NBTTagEnd> {
	private static Constructor<NBTTagEnd> nbtTagEndConstructor;
	
	public static Constructor<NBTTagEnd> getNbtTagEndConstructor() {
		if (nbtTagEndConstructor == null) {
			try {
				nbtTagEndConstructor = NBTTagEnd.class.getDeclaredConstructor();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
			
			nbtTagEndConstructor.setAccessible(true);
		}
		return nbtTagEndConstructor;
	}
	
	@Override
	public JsonElement serialize(NBTTagEnd src, Type typeOfSrc, JsonSerializationContext context) {
		return JsonNull.INSTANCE;
	}
	
	@Override
	public NBTTagEnd deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		try {
			return getNbtTagEndConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}