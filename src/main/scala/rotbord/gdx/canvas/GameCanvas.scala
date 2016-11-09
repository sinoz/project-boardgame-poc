package rotbord.gdx.canvas

import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.{Gdx, InputMultiplexer}
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.Disposable
import com.badlogic.gdx.utils.viewport.ScreenViewport

object GameCanvas extends Disposable {
  val batch = new SpriteBatch()
  val stage = new Stage(new ScreenViewport(), batch)
  val inputMultiplexer = new InputMultiplexer()

  private var active = Set[Scene]()
  private var presented: Option[Scene] = None

  def transitionTo(targetScene: Scene) = {
    if (presented.isDefined) {
      presented.get.hide()
    }

    presented = Some(targetScene)
    if (!active.contains(targetScene)) {
      active += targetScene
    }

    updateViewport(Gdx.graphics.getWidth, Gdx.graphics.getHeight, centerCamera = true)
    presented.get.show()
  }

  private def updateViewport(width: Int, height: Int, centerCamera: Boolean) = {
    stage.getViewport.update(width, height, centerCamera)
  }

  def resize(width: Int, height: Int) = {
    if (presented.isDefined) {
      presented.get.resize(width, height)
      updateViewport(width, height, centerCamera = true)
    }
  }

  def hide(): Unit = {
    if (presented.isDefined) {
      presented.get.hide()
    }
  }

  def show(): Unit = {
    if (presented.isDefined) {
      presented.get.show()
    }
  }

  def render(): Unit = {
    glClearScreen()

    if (presented.isDefined) {
      stage.act(Gdx.graphics.getDeltaTime)
      stage.draw()

      presented.get.render()
    }
  }

  def glClearScreen(): Unit = {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT)
  }

  def resume(): Unit = {
    if (presented.isDefined) {
      presented.get.resume()
    }
  }

  def pause(): Unit = {
    if (presented.isDefined) {
      presented.get.pause()
    }
  }

  override def dispose(): Unit = {
    if (presented.isDefined) {
      presented.get.dispose()
    }

    stage.dispose()
  }

  inputMultiplexer.addProcessor(stage)
  Gdx.input.setInputProcessor(inputMultiplexer)
}

trait Scene extends Disposable {
  def resize(width: Int, height: Int): Unit
  def hide(): Unit
  def show(): Unit
  def render(): Unit
  def pause(): Unit
  def resume(): Unit
}
