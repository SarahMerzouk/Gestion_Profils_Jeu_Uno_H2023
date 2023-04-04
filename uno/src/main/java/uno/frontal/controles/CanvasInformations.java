package uno.frontal.controles;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import uno.commun.monde2d.MondeUno2d;

public class CanvasInformations extends ResizableWorld2dCanvasFx {

	@Override
	protected void initialize() {
		 setInitialWorldSize(MondeUno2d.LARGEUR_MONDE, MondeUno2d.HAUTEUR_MONDE);	
	}
}
