package logic.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import frame.Localisation;

public class LocalisationParser
{
	Gson json = new Gson();
	public Localisation parse(String languageOfUser)
	{
		File file = new File("lang/" + languageOfUser + ".json");
		Localisation local = null;
		try
		{
			String fileText = FileUtils.readFileToString(file, "UTF-8");
			local = json.fromJson(fileText,new TypeToken<Localisation>(){}.getType());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return local;
	}

	public void Russian()
	{
		Localisation local = new Localisation();

		
		local.mainMenuFile = "����";
		local.mainMenuFileSave = "���������";
		local.mainMenuFileLoad = "���������";


		local.mainMenuType = "���";
		local.mainMenuTypeRect = "�������������";
		local.mainMenuTypeLine = "�����";
		local.mainMenuTypeOval = "����";
		local.mainMenuTypeRoundRect = "�����.����.";

		local.mainMenuColor = "����";
		local.mainMenuColorYellow = "������";
		local.mainMenuColorGreen = "�������";
		local.mainMenuColorRed = "�������";
		local.mainMenuColorBlue = "�����";


		local.mainMenuWidth = "�������";
		local.mainMenuWidthDefault = "�� ���������";
		local.mainMenuWidthThin = "������";
		local.mainMenuWidthMiddle = "�������";
		local.mainMenuWidthThick = "�������";

		local.shortcutPanelButtonYellow = "������";
		local.shortcutPanelButtonGreen = "�������";
		local.shortcutPanelButtonRed = "�������";

		local.shortcutPanelButtonThin = "������";
		local.shortcutPanelButtonMiddle = "�������";
		local.shortcutPanelButtonThick = "�������";

		local.toolBarButtonAddTab = "�������� �������";
		local.toolBarButtonDeleteTab = "������� �������";

		local.toolBarButtonChooseColor = "������� �������";

		local.toolBarButtonRect = "���������.";
		local.toolBarButtonOval = "����";
		local.toolBarButtonLine = "�����";
		local.toolBarButtonRRect = "�����.����.";

		local.popupMenuType = "���";
		local.popupMenuTypeRect = "�������������";
		local.popupMenuTypeLine = "�����";
		local.popupMenuTypeOval = "����";
		local.popupMenuTypeRoundRect = "������������ ������������";

		local.popupMenuColor = "����";
		local.popupMenuColorYellow = "������";
		local.popupMenuColorGreen = "�������";
		local.popupMenuColorRed = "�������";
		local.popupMenuColorBlue = "�����";

		local.popupMenuWidth = "�������";
		local.popupMenuWidthDefault = "�� ���������";
		local.popupMenuWidthThin = "������";
		local.popupMenuWidthMiddle = "�������";
		local.popupMenuWidthThick = "�������";
		
		local.messageForUserWhenTabNameChoosing = "������� ��� ����� ������� (�� ��������� ����� ����� ���������� �����):";

		File file = new File("lang/RU.json");

		try
		{
			FileUtils.write(file, json.toJson(local), "UTF-8");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void Ukranian()
	{
		Localisation local = new Localisation();

		
		local.mainMenuFile = "����";
		local.mainMenuFileSave = "��������";
		local.mainMenuFileLoad = "�����������";


		local.mainMenuType = "���";
		local.mainMenuTypeRect = "�����������";
		local.mainMenuTypeLine = "�i�i�";
		local.mainMenuTypeOval = "����";
		local.mainMenuTypeRoundRect = "�����.����.";

		local.mainMenuColor = "���i�";
		local.mainMenuColorYellow = "������";
		local.mainMenuColorGreen = "�������";
		local.mainMenuColorRed = "��������";
		local.mainMenuColorBlue = "���i�";


		local.mainMenuWidth = "�������";
		local.mainMenuWidthDefault = "�� �����������";
		local.mainMenuWidthThin = "�����";
		local.mainMenuWidthMiddle = "�������";
		local.mainMenuWidthThick = "������";

		local.shortcutPanelButtonYellow = "������";
		local.shortcutPanelButtonGreen = "�������";
		local.shortcutPanelButtonRed = "��������";

		local.shortcutPanelButtonThin = "�����";
		local.shortcutPanelButtonMiddle = "�������";
		local.shortcutPanelButtonThick = "������";

		local.toolBarButtonAddTab = "������ �������";
		local.toolBarButtonDeleteTab = "�������� �������";

		local.toolBarButtonChooseColor = "�i������ ���i���";

		local.toolBarButtonRect = "���������.";
		local.toolBarButtonOval = "����";
		local.toolBarButtonLine = "�i�i�";
		local.toolBarButtonRRect = "�����.����.";

		local.popupMenuType = "���";
		local.popupMenuTypeRect = "�����������";
		local.popupMenuTypeLine = "�i�i�";
		local.popupMenuTypeOval = "����";
		local.popupMenuTypeRoundRect = "����������� �����������";

		local.popupMenuColor = "���i�";
		local.popupMenuColorYellow = "������";
		local.popupMenuColorGreen = "�������";
		local.popupMenuColorRed = "��������";
		local.popupMenuColorBlue = "���i�";

		local.popupMenuWidth = "�������";
		local.popupMenuWidthDefault = "�� �����������";
		local.popupMenuWidthThin = "�����";
		local.popupMenuWidthMiddle = "�������";
		local.popupMenuWidthThick = "������";
		
		local.messageForUserWhenTabNameChoosing = "����i�� i�'� ����i ������� (�� ����������� ���� �������� ���������� �����):";

		File file = new File("lang/UA.json");

		try
		{
			FileUtils.write(file, json.toJson(local), "UTF-8");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void English()
	{
		
		Localisation local = new Localisation();
		local.mainMenuFile = "File";
		local.mainMenuFileSave = "Save";
		local.mainMenuFileLoad = "Load";


		local.mainMenuType = "Type";
		local.mainMenuTypeRect = "Rectangle";
		local.mainMenuTypeLine = "Line";
		local.mainMenuTypeOval = "Oval";
		local.mainMenuTypeRoundRect = "Rounded rectangle";

		local.mainMenuColor = "Color";
		local.mainMenuColorYellow = "Yellow";
		local.mainMenuColorGreen = "Green";
		local.mainMenuColorRed = "Red";
		local.mainMenuColorBlue = "Blue";


		local.mainMenuWidth = "Width";
		local.mainMenuWidthDefault = "Default";
		local.mainMenuWidthThin = "Thin";
		local.mainMenuWidthMiddle = "Middle";
		local.mainMenuWidthThick = "Thick";

		local.shortcutPanelButtonYellow = "Yellow";
		local.shortcutPanelButtonGreen = "Green";
		local.shortcutPanelButtonRed = "Red";

		local.shortcutPanelButtonThin = "Thin";
		local.shortcutPanelButtonMiddle = "Middle";
		local.shortcutPanelButtonThick = "Thick";

		local.toolBarButtonAddTab = "Add Tab";
		local.toolBarButtonDeleteTab = "Delete Tab";

		local.toolBarButtonChooseColor = "Choose color";

		local.toolBarButtonRect = "Rect";
		local.toolBarButtonOval = "Oval";
		local.toolBarButtonLine = "Line";
		local.toolBarButtonRRect = "RRect";

		local.popupMenuType = "Type";
		local.popupMenuTypeRect = "Rectangle";
		local.popupMenuTypeLine = "Line";
		local.popupMenuTypeOval = "Oval";
		local.popupMenuTypeRoundRect = "Rounded rectangle";

		local.popupMenuColor = "Color";
		local.popupMenuColorYellow = "Yellow";
		local.popupMenuColorGreen = "Green";
		local.popupMenuColorRed = "Red";
		local.popupMenuColorBlue = "Blue";

		local.popupMenuWidth = "Width";
		local.popupMenuWidthDefault = "Default";
		local.popupMenuWidthThin = "Thin";
		local.popupMenuWidthMiddle = "Middle";
		local.popupMenuWidthThick = "Thick";
		
		local.messageForUserWhenTabNameChoosing = "Put the name of a new tab(by default here will be the number of it):";
		

		File file = new File("lang/EN.json");

		try
		{
			FileUtils.write(file, json.toJson(local), "UTF-8");
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}


}


