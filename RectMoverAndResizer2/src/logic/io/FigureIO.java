package logic.io;

import java.util.ArrayList;

import model.MFigure;

public interface FigureIO
{
	public void save(ArrayList<MFigure> figs);
	public ArrayList<MFigure> load();
}
