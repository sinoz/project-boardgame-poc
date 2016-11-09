package rotbord
package gdx

import com.badlogic.gdx.Gdx

trait GdxHelpers {
  def runLater(callback: UnitCallback) = {
    Gdx.app.postRunnable(new Runnable {
      override def run(): Unit = callback()
    })
  }
}
