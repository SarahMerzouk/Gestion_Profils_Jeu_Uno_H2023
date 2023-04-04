package uno.commun.monde2d;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.fx.world2d.World2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MondeUno2d extends World2dFx {

	public static final double LARGEUR_MONDE = 640;
	public static final double HAUTEUR_MONDE = 360;

	private Dessin2d dessin;

	@Override
	protected void initialize() {
		setWidth(LARGEUR_MONDE);
		setHeight(HAUTEUR_MONDE);

		dessin = new Dessin2d();

		addObject2d(dessin);

	}

	@Override
	public void drawOn(ResizableWorld2dCanvasFx canvas) {
		canvas.drawOnWorld(gc -> {
			dessinerTerrain(gc);
		});

		super.drawOn(canvas);
	}

	private void dessinerTerrain(GraphicsContext gc) {
		gc.save();
		gc.setStroke(Color.RED);
		gc.setLineWidth(1);

		gc.strokeRect(0, 0, getWidth(), getHeight());

		gc.restore();
	}

	@Override
	protected void onMouseEventNotConsumed(World2dMouseEventFx mouseEvent) {
		// TODO Auto-generated method stub

	}
}
