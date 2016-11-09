package rotbord.gdx.canvas.game.grid

import java.util.Random

import com.badlogic.gdx.scenes.scene2d.ui.{Skin, Table}
import rotbord.gdx.canvas.game.grid.tile._

object TileGrid {
  val GridWidth = 11
  val GridHeight = 11
  val TileSize = 50F
  val RandomTileBound = 20
  val TileRandom = new Random()
}

final class TileGrid(implicit skin: Skin) extends Table(skin) {
  import TileGrid._

  def selectRandomTileType(bound: Int) = TileRandom.nextInt(bound) match {
    case 1 => new MoveBackTile()
    case 3 => new PointRewardTile()
    case 7 => new JailTile()
    case 9 => new PointRewardTile()
    case 11 => new MoveForwardTile()
    case 13 => new PointRewardTile()
    case 15 => new MoveBackTile()
    case 17 => new JailTile()
    case _ => new BlankTile()
  }

  defaults().width(TileSize).height(TileSize)

  (0 until GridHeight) foreach { y =>
    (0 until GridWidth) foreach { x =>
      val tileType = selectRandomTileType(RandomTileBound)
      tileType.setDisabled(true)

      if (x >= 1 && x < (GridWidth - 1) && y >= 1 && y < (GridHeight - 1)) {
        (x, y) match {
          case (5, 5) =>
            add(new BridgedTile())
          case (5, _) =>
            add(tileType)
          case (_, 5) =>
            add(tileType)

          case _ =>
            add()
        }
      } else {
        if (x == (GridWidth - 1) && y == (GridHeight - 1)) {
          add(new LapTile())
        } else {
          add(tileType)
        }
      }
    }

    row()
  }

  pack()
}
