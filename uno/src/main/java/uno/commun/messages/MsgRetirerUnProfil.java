package uno.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import uno.commun.modeles.ModeleProfil;

public class MsgRetirerUnProfil extends MessageNtro {
	
	private String idProfil;
	
	
	
	public MsgRetirerUnProfil() {
		
	}

	public String getIdProfil() {
		return idProfil;
	}

	public void setIdProfil(String idProfil) {
		this.idProfil = idProfil;
	}
	
	public void retirerLeProfil(ModeleProfil profil) {
		profil.retirerLeProfil(idProfil);
	}

}
