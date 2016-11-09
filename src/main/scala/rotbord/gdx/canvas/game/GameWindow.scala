package rotbord.gdx.canvas.game

import com.badlogic.gdx.scenes.scene2d.ui.{Skin, Table}
import rotbord.gdx.canvas.game.grid.TileGridPanel
import rotbord.gdx.canvas.game.info.InformationPanel

final class GameWindow(implicit skin: Skin) extends Table(skin) {
  val grid = new TileGridPanel()
  val infoPanel = new InformationPanel()

  add(grid)
  add(infoPanel).top()

  setFillParent(true)
  setBackground("default-window")
}
