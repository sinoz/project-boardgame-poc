package rotbord.gdx.canvas.game.info

import com.badlogic.gdx.scenes.scene2d.ui.{SelectBox, Skin}

final class AnswerDropdown(implicit skin: Skin) extends SelectBox[String](skin) {
  setItems("Answer 1", "Answer 2", "Answer 3", "Answer 4")
}
