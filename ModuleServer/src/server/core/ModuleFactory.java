package server.core;

import java.util.HashMap;

import server.modules.LoggingModule;

public class ModuleFactory
{
	private HashMap<String, Module> modules = new HashMap<>();
	private static ModuleFactory instance = new ModuleFactory();
	
	public Module getModule(String moduleName)
	{
		moduleName = "server.modules." + moduleName;
		Module ret = null;
		ret = modules.get(moduleName);
		System.out.println("I've found nothing in map");
		if(ret == null)
		{
			System.out.println("trying to get a class by name");
			try
			{
				ret = (Module) Class.forName(moduleName).newInstance();
				System.out.println("I've got a new module called: " + moduleName);
				
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e)
			{
				e.printStackTrace();
				return null;
			}
			modules.put(moduleName, ret);
		}
		return ret;
	}

	public static ModuleFactory getInstance()
	{
		return instance;
	}
}
