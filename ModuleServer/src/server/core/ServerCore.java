package server.core;

public class ServerCore extends Thread
{
	SingleToneMessages msgDB;
	ModuleFactory mFact;
	ServerSender sender;

	public ServerCore()
	{
		msgDB = SingleToneMessages.getInstance();
		mFact = ModuleFactory.getInstance();
		sender = ServerSender.getInstance();
		start();
	}

	@Override
	public void run()
	{
		String line = "";
		String responseOfModule = "";
		System.out.println("started a core lst");
		while(true)
		{
			line = msgDB.get();
			if(!line.equals(""))
			{
				System.out.println("trying to redirect this: " + line);
				
				String[] partsOfLine = line.split(";", 3);
				String targetModuleName = partsOfLine[1];
				
				Module mod = mFact.getModule(targetModuleName);
				if(mod != null)
				{
					System.out.println("Module founded!");
					responseOfModule = mod.handleCommand(line);
					System.out.println("Module sent me this: " + responseOfModule);
				}
				else
				{
					responseOfModule = "Didn't find the module";
				}
				sender.send(responseOfModule);
			}
			try
			{
				sleep(500);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

}
