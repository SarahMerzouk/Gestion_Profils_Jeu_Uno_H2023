package uno.commun.monde2d;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.paint.Color;
import ca.ntro.core.initialization.Ntro;

public class Dessin2d extends ObjetUno2d {

	private static final double EPSILON = 1;

	public Dessin2d() {
		super();
	}

	@Override
	public void initialize() {
		setWidth(10);
		setHeight(10);
		setTopLeftX(100);
		setTopLeftY(100);

		setSpeedX(50 + Ntro.random().nextInt(100));
		setSpeedY(50 + Ntro.random().nextInt(100));
	}

	@Override
	public void drawOn(ResizableWorld2dCanvasFx canvas) {

		canvas.drawOnWorld(gc -> {

			gc.setStroke(Color.WHITE);
			gc.strokeText("INFORMATIONS DU JOUEUR", getTopLeftX(), getTopLeftY());
			gc.setLineWidth(5);

		});

	}

	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		return false;
	}

	@Override
	public String id() {
		return "dessin1";
	}

	@Override
	public void onTimePasses(double secondsElapsed) {
		super.onTimePasses(secondsElapsed);

		if (dessinFrappeMurGauche()) {

			dessinRebondiSurMurGauche();

		} else if (dessinFrappeMurDroit()) {

			dessinRebondiSurMurDroit();

		} else if (dessinFrappePlafond()) {

			dessinRebondiSurPlafond();

		} else if (dessinFrappePlancher()) {

			dessinRebondiSurPlancher();
		}
	}

	private boolean dessinFrappePlancher() {
		return collidesWith(0, getWorld2d().getHeight(), getWorld2d().getWidth(), 1);
	}

	private boolean dessinFrappePlafond() {
		return collidesWith(0, 0, getWorld2d().getWidth(), 1);
	}

	private boolean dessinFrappeMurDroit() {
		return collidesWith(getWorld2d().getWidth(), 0, 1, getWorld2d().getHeight());
	}

	private boolean dessinFrappeMurGauche() {
		return collidesWith(0, 0, 1, getWorld2d().getHeight());
	}

	private void dessinRebondiSurPlancher() {
		setTopLeftY(getWorld2d().getHeight() - this.getHeight() - EPSILON);
		setSpeedY(-getSpeedY());
	}

	private void dessinRebondiSurPlafond() {
		setTopLeftY(0 + EPSILON);
		setSpeedY(-getSpeedY());
	}

	private void dessinRebondiSurMurDroit() {
		setTopLeftX(getWorld2d().getWidth() - this.getWidth() - EPSILON);
		setSpeedX(-getSpeedX());
	}

	private void dessinRebondiSurMurGauche() {
		setTopLeftX(0 + EPSILON);
		setSpeedX(-getSpeedX());
	}
}
