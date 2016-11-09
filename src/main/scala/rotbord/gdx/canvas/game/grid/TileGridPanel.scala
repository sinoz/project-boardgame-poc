package rotbord.gdx.canvas.game.grid

import com.badlogic.gdx.scenes.scene2d.ui.{Skin, Window}

final class TileGridPanel(implicit skin: Skin) extends Window("", skin) {
  val grid = new TileGrid()

  add(grid).row()
  add("<insert what's happening here>")
  pack()

  setBackground("default-window")
}
