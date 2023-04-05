package common_method;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CommonMethodUtilities {

	public static void evidenceFileCreator(String fileName , String request , String response) throws IOException
	{
		File newTextFile = new File("D:\\restAssuredEvidence\\" + fileName + ".txt");
		if(newTextFile.createNewFile())
		{
		FileWriter dataWriter = new FileWriter(newTextFile) ;
		dataWriter.write("Requestbody is :\n" +request+ "\n\n");
		dataWriter.write("Responsebody is :\n" +response);
		dataWriter.close();
		System.out.println("request and responsebody data saved in :" +newTextFile.getName());
		}
		else
		{
			System.out.println(newTextFile.getName()+ " Already exist take a backup of it ! ");
		}
	}
}
