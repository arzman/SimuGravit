package arz.simugravit.model;

/**
 * Classe représentant un coprs physique
 *
 */
public class Corps {
	
	
	//TODO passer Vitesse en cartésion
	
	
	private double _masse;
	
	private double _posX;
	
	private double _posY;
	
	private double _normVit;
	
	private double _orienVit;
	
	private boolean _isMobile;
	
	
	public Corps() {
		
		setMobile(true);
		
	}


	public double getMasse() {
		return _masse;
	}


	public void setMasse(double masse) {
		_masse = masse;
	}


	public double getPosX() {
		return _posX;
	}


	public void setPosX(double posX) {
		_posX = posX;
	}


	public double getPosY() {
		return _posY;
	}


	public void setPosY(double posY) {
		_posY = posY;
	}




	public boolean isMobile() {
		return _isMobile;
	}


	public void setMobile(boolean isMobile) {
		_isMobile = isMobile;
	}


	public double getNormVit() {
		return _normVit;
	}


	public void setNormVit(double normVit) {
		_normVit = normVit;
	}


	public double getOrienVit() {
		return _orienVit;
	}


	public void setOrienVit(double orienVit) {
		_orienVit = orienVit;
	}

}
