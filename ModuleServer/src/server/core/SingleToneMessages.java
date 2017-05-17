package server.core;

import java.util.ArrayList;

public class SingleToneMessages
{
	private ArrayList<String> messages = new ArrayList<>();
	private static SingleToneMessages instance = new SingleToneMessages();
	
	public static SingleToneMessages getInstance()
	{
		return instance;
	}
	
	
	public void addMessage(String str)
	{
		messages.add(str);
		System.out.println("added this: " + str);
	}
	
	public String get()
	{
		String ret = "";
		if(messages.size() > 0)
		{
			ret = messages.get(0);
			messages.remove(0);
			System.out.println("I'll send this to core: " + ret);
		}
		return ret;
	}
}
