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

		
		local.mainMenuFile = "Файл";
		local.mainMenuFileSave = "Сохранить";
		local.mainMenuFileLoad = "Загрузить";


		local.mainMenuType = "Тип";
		local.mainMenuTypeRect = "Прямоугольник";
		local.mainMenuTypeLine = "Линия";
		local.mainMenuTypeOval = "Овал";
		local.mainMenuTypeRoundRect = "Кругл.прям.";

		local.mainMenuColor = "Цвет";
		local.mainMenuColorYellow = "Желтый";
		local.mainMenuColorGreen = "Зеленый";
		local.mainMenuColorRed = "Красный";
		local.mainMenuColorBlue = "Синий";


		local.mainMenuWidth = "Толщина";
		local.mainMenuWidthDefault = "По умолчанию";
		local.mainMenuWidthThin = "Тонкая";
		local.mainMenuWidthMiddle = "Средняя";
		local.mainMenuWidthThick = "Толстая";

		local.shortcutPanelButtonYellow = "Желтый";
		local.shortcutPanelButtonGreen = "Зеленый";
		local.shortcutPanelButtonRed = "Красный";

		local.shortcutPanelButtonThin = "Тонкая";
		local.shortcutPanelButtonMiddle = "Средняя";
		local.shortcutPanelButtonThick = "Толстая";

		local.toolBarButtonAddTab = "Добавить вкладку";
		local.toolBarButtonDeleteTab = "Удалить вкладку";

		local.toolBarButtonChooseColor = "Открыть палитру";

		local.toolBarButtonRect = "Прямоугол.";
		local.toolBarButtonOval = "Овал";
		local.toolBarButtonLine = "Линия";
		local.toolBarButtonRRect = "Кругл.прям.";

		local.popupMenuType = "Тип";
		local.popupMenuTypeRect = "Прямоугольник";
		local.popupMenuTypeLine = "Линия";
		local.popupMenuTypeOval = "Овал";
		local.popupMenuTypeRoundRect = "Закругленный рямоугольник";

		local.popupMenuColor = "Цвет";
		local.popupMenuColorYellow = "Желтый";
		local.popupMenuColorGreen = "Зеленый";
		local.popupMenuColorRed = "Красный";
		local.popupMenuColorBlue = "Синий";

		local.popupMenuWidth = "Толщина";
		local.popupMenuWidthDefault = "По умолчанию";
		local.popupMenuWidthThin = "Тонкая";
		local.popupMenuWidthMiddle = "Средняя";
		local.popupMenuWidthThick = "Толстая";
		
		local.messageForUserWhenTabNameChoosing = "Введите имя новой вкладки (по умолчанию будет задан порядковый номер):";

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

		
		local.mainMenuFile = "Файл";
		local.mainMenuFileSave = "Зберегти";
		local.mainMenuFileLoad = "Завантажити";


		local.mainMenuType = "Тип";
		local.mainMenuTypeRect = "Прямокутник";
		local.mainMenuTypeLine = "Лiнiя";
		local.mainMenuTypeOval = "Овал";
		local.mainMenuTypeRoundRect = "Кругл.прям.";

		local.mainMenuColor = "Колiр";
		local.mainMenuColorYellow = "Жовтий";
		local.mainMenuColorGreen = "Зелений";
		local.mainMenuColorRed = "Червоний";
		local.mainMenuColorBlue = "Синiй";


		local.mainMenuWidth = "Товщина";
		local.mainMenuWidthDefault = "За замовченням";
		local.mainMenuWidthThin = "Тонка";
		local.mainMenuWidthMiddle = "Середня";
		local.mainMenuWidthThick = "Товста";

		local.shortcutPanelButtonYellow = "Жовтий";
		local.shortcutPanelButtonGreen = "Зелений";
		local.shortcutPanelButtonRed = "Червоний";

		local.shortcutPanelButtonThin = "Тонка";
		local.shortcutPanelButtonMiddle = "Середня";
		local.shortcutPanelButtonThick = "Товста";

		local.toolBarButtonAddTab = "Додати вкладку";
		local.toolBarButtonDeleteTab = "Видалити вкладку";

		local.toolBarButtonChooseColor = "Вiдкрити палiтру";

		local.toolBarButtonRect = "Прямокутн.";
		local.toolBarButtonOval = "Овал";
		local.toolBarButtonLine = "Лiнiя";
		local.toolBarButtonRRect = "Кругл.прям.";

		local.popupMenuType = "Тип";
		local.popupMenuTypeRect = "Прямокутник";
		local.popupMenuTypeLine = "Лiнiя";
		local.popupMenuTypeOval = "Овал";
		local.popupMenuTypeRoundRect = "Закруглений прямокутник";

		local.popupMenuColor = "Колiр";
		local.popupMenuColorYellow = "Жовтий";
		local.popupMenuColorGreen = "Зелений";
		local.popupMenuColorRed = "Червоний";
		local.popupMenuColorBlue = "Синiй";

		local.popupMenuWidth = "Товщина";
		local.popupMenuWidthDefault = "За замовченням";
		local.popupMenuWidthThin = "Тонка";
		local.popupMenuWidthMiddle = "Середня";
		local.popupMenuWidthThick = "Товста";
		
		local.messageForUserWhenTabNameChoosing = "Введiть iм'я новоi вкладки (за замовченням буде вказаний порядковий номер):";

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


