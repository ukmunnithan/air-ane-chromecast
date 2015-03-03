package com.mesmotronic.ane.aircast;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

import com.adobe.fre.FREArray;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class BaseFunction implements FREFunction
{
	@Override
	public FREObject call(FREContext context, FREObject[] args)
	{
		return null;
	}
	
	protected String getStringFromFREObject(FREObject object)
	{
		try
		{
			return object.getAsString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "";
		}
	}
	
	protected Boolean getBooleanFromFREObject(FREObject object)
	{
		try
		{
			return object.getAsBool();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	protected Double getDoubleFromFREObject(FREObject object)
	{
		try
		{
			return object.getAsDouble();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0.0;
		}
	}
	
	protected List<String> getListOfStringFromFREArray(FREArray array)
	{
		List<String> result = new ArrayList<String>();
		
		try
		{
			for (int i = 0; i < array.getLength(); i++)
			{
				try
				{
					result.add(getStringFromFREObject(array.getObjectAt((long)i)));
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	protected Bundle getBundleOfStringFromFREArrays(FREArray keys, FREArray values)
	{
		Bundle result = new Bundle();
		
		try
		{
			long length = Math.min(keys.getLength(), values.getLength());
			for (int i = 0; i < length; i++)
			{
				try
				{
					String key = getStringFromFREObject(keys.getObjectAt((long)i));
					String value = getStringFromFREObject(values.getObjectAt((long)i));
					result.putString(key, value);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		return result;
	}
}
