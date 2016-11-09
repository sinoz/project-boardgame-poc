import com.badlogic.gdx.ApplicationListener
import com.badlogic.gdx.backends.lwjgl.{LwjglApplication, LwjglApplicationConfiguration}
import rotbord.gdx.GdxHelpers
import rotbord.gdx.canvas.GameCanvas
import rotbord.gdx.canvas.game.GameScene

package object rotbord extends App {
  val Release = 0
  val Build = 1
  val Patch = 1
  val Title = s"RotBord v$Release.$Build.$Patch"

  GLBoardGameApp(
    onCreate => {
      GameCanvas.transitionTo(GameScene)
      // TODO
    },

    onExit => {
      println("On exit")
    }
  )

  type UnitCallback = Unit => Unit

  private object DefaultGLBoardGameConfig extends LwjglApplicationConfiguration {
    title = Title
    width = LwjglApplicationConfiguration.getDesktopDisplayMode.width
    height = LwjglApplicationConfiguration.getDesktopDisplayMode.height
    resizable = true
    vSyncEnabled = true
  }

  private object GLBoardGameApp {
    def apply(onCreate: UnitCallback, onExit: UnitCallback) = new GLBoardGameApp(onCreate, onExit)
  }

  private class GLBoardGameApp(onCreate: UnitCallback, onExit: UnitCallback) extends LwjglApplication(GLAppEventDelegator, DefaultGLBoardGameConfig) with GdxHelpers {
    override def exit(): Unit = onExit()

    runLater(onCreate)
  }

  private object GLAppEventDelegator extends ApplicationListener {
    override def create(): Unit = {
      // nothing
    }

    override def resize(width: Int, height: Int): Unit = GameCanvas.resize(width, height)

    override def dispose(): Unit = GameCanvas.dispose()

    override def pause(): Unit = GameCanvas.pause()

    override def render(): Unit = GameCanvas.render()

    override def resume(): Unit = GameCanvas.resume()
  }
}
