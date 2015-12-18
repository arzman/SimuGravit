
package arz.simugravit.application;

import java.util.ArrayList;

import arz.simugravit.application.exception.SimuApplicationException;
import arz.simugravit.model.Corps;

/**
 * Le conteneur applicatif du contexte de simulation : contient les corps en
 * mouvement et permet de modifier leurs attributs.
 *
 */
public class ContextManager {

	public static final int MASSE = 0;

	public static final int POS_X = 1;

	public static final int POS_Y = 2;

	public static final int NORME_VIT = 3;

	public static final int ORIEN_VIT = 4;

	public static final int IS_MOBILE = 5;

	/**
	 * L'unique instance du singleton
	 */
	private static ContextManager _instance;

	private ArrayList<Corps> _corpsList;

	private final int NB_OBJECT = 3;

	private ContextManager() {

		_corpsList = new ArrayList<Corps>();

		for (int i = 0; i < NB_OBJECT; i++) {

			Corps c = new Corps();
			_corpsList.add(c);

		}

	}

	public static ContextManager getInstance() {

		if (_instance == null) {
			_instance = new ContextManager();
		}

		return _instance;

	}

	public int getNbrObject() {
		return NB_OBJECT;
	}

	/**
	 * Met à jour un attribut d'un objet
	 * 
	 * @param num
	 *            le numéro de l'objet
	 * @param numField
	 *            le numéro de l'attriubt
	 * @param value
	 *            la nouvelle valeur
	 * @throws SimuApplicationException
	 *             si la mise à jour ne s'est pas correctement déroulée
	 */
	public void updateObject(int num, int numField, String value) throws SimuApplicationException {

		if (num >= NB_OBJECT) {

			throw new SimuApplicationException("Le numéro du corps est invalide : " + num);
		} else {

			Corps c = _corpsList.get(num);

			try {

				switch (numField) {

				case MASSE:
					c.setMasse(Double.parseDouble(value));
					break;
				case POS_X:
					c.setPosX(Double.parseDouble(value));
					break;
				case POS_Y:
					c.setPosY(Double.parseDouble(value));
					break;
				case NORME_VIT:
					c.setNormVit(Double.parseDouble(value));
					break;
				case ORIEN_VIT:
					c.setOrienVit(Double.parseDouble(value));
					break;
				case IS_MOBILE:
					c.setMobile(Boolean.parseBoolean(value));
					break;
				default:
					throw new SimuApplicationException("Champ invalide");

				}

			} catch (NumberFormatException ex) {

				throw new SimuApplicationException("Impossible de mettre à jour l'objet", ex);

			}
		}

	}

	/**
	 * Retourne la valeur sous forme de {@link Double} d'un attribut
	 * 
	 * @param num
	 *            le numéro de l'objet
	 * @param numField
	 *            le numéro du champ
	 * @return
	 * @throws SimuApplicationException
	 *             Exception en cas d'echec de la récupération
	 */
	public double getDoubleAttributeValue(int num, int numField) throws SimuApplicationException {

		double res;

		if (num >= NB_OBJECT) {

			throw new SimuApplicationException("Le numéro du corps est invalide : " + num);
		} else {

			Corps c = _corpsList.get(num);

			switch (numField) {

			case MASSE:
				res = c.getMasse();
				break;
			case POS_X:
				res = c.getPosX();
				break;
			case POS_Y:
				res = c.getPosY();
				break;
			case NORME_VIT:
				res = c.getNormVit();
				break;
			case ORIEN_VIT:
				res = c.getOrienVit();
				break;
			default:
				throw new SimuApplicationException("Champ invalide");

			}
		}

		return res;

	}

	public boolean getBooleanAttributeValue(int num, int numField) throws SimuApplicationException {
		boolean res;

		if (num >= NB_OBJECT) {

			throw new SimuApplicationException("Le numéro du corps est invalide : " + num);
		} else {

			Corps c = _corpsList.get(num);

			switch (numField) {

			case IS_MOBILE:
				res = c.isMobile();
				break;
			default:
				throw new SimuApplicationException("Champ invalide");
			}
			return res;

		}
	}

	public void updateDoubleObject(int num, int numField, double value) throws SimuApplicationException {
		
		
		if (num >= NB_OBJECT) {

			throw new SimuApplicationException("Le numéro du corps est invalide : " + num);
		} else {

			Corps c = _corpsList.get(num);

			try {

				switch (numField) {

				case MASSE:
					c.setMasse(value);
					break;
				case POS_X:
					c.setPosX(value);
					break;
				case POS_Y:
					c.setPosY(value);
					break;
				case NORME_VIT:
					c.setNormVit(value);
					break;
				case ORIEN_VIT:
					c.setOrienVit(value);
					break;
				default:
					throw new SimuApplicationException("Champ invalide");

				}

			} catch (NumberFormatException ex) {

				throw new SimuApplicationException("Impossible de mettre à jour l'objet", ex);

			}
		}
		
	}

}
