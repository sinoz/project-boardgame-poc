package rotbord.gdx.canvas.game

import com.badlogic.gdx.scenes.scene2d.ui.Skin
import rotbord.gdx.assets.GameAssets
import rotbord.gdx.canvas.{GameCanvas, Scene}

object GameScene extends Scene {
  private implicit val skin = GameAssets.fetch("uiskin", classOf[Skin])

  val window = new GameWindow()
  GameCanvas.stage.addActor(window)

  override def resize(width: Int, height: Int): Unit = {
    // TODO
  }

  override def hide(): Unit = {
    window.setVisible(false)
  }

  override def pause(): Unit = {
    // TODO
  }

  override def render(): Unit = {
    // TODO
  }

  override def show(): Unit = {
    window.setVisible(true)
  }

  override def resume(): Unit = {
    // TODO
  }

  override def dispose(): Unit = {
    // TODO
  }
}
