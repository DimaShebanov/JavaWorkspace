package server.modules;

import server.core.Module;

public class LoggingModule implements Module
{

	@Override
	public String handleCommand(String command)
	{
		System.out.println("Core sent me this :" + command);
		String[] argsOfCommand = command.split(";", 3);
		String fromWhoCommand = argsOfCommand[0];
		String whoGetCommand = argsOfCommand[1];
		String message = argsOfCommand[2];
		System.out.println("parsed message, it is: " + message);
		
		String returnText = whoGetCommand + ";" + fromWhoCommand + ";" + "it's ok,I've got it!";
		return returnText;
	}

}
