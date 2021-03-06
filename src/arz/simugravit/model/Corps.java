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
	
	private double _vitX;
	
	private double _vitY;
	
	private double _aX;
	
	private double _aY;
	
	private boolean _isMobile;
	
	
	public Corps() {
		
		setMobile(true);
		_aX = 0;
		_aY = 0;
		
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


	public double getVitY() {
		return _vitY;
	}


	public void setVitY(double vitY) {
		_vitY = vitY;
	}


	public double getVitX() {
		return _vitX;
	}


	public void setVitX(double vitX) {
		_vitX = vitX;
	}


	public double getaX() {
		return _aX;
	}


	public void setaX(double aX) {
		_aX = aX;
	}


	public double getaY() {
		return _aY;
	}


	public void setaY(double aY) {
		_aY = aY;
	}

}
