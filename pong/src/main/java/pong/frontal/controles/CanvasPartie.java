package pong.frontal.controles;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import pong.commun.monde2d.MondePong2d;

public class CanvasPartie extends ResizableWorld2dCanvasFx {

	@Override
	protected void initialize() {
		 setInitialWorldSize(MondePong2d.LARGEUR_MONDE, MondePong2d.HAUTEUR_MONDE);
	}
	
	public void displayFps(String imagesParSeconde) {
		drawOnCanvas(gc -> {

			gc.fillText(imagesParSeconde, 0, 12);

		});
	}
}
