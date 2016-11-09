package rotbord.gdx.canvas.game.info

import com.badlogic.gdx.scenes.scene2d.ui.{Skin, Window}

final class InformationPanel(implicit skin: Skin) extends Window("", skin) {
  defaults().left()

  add("Points to win")
  add("30").right().row()
  add("Your points: ")
  add("0").right().row()
  add("CPU points: ").left()
  add("0").right().row()

  add("Press to roll dices").padRight(10F)
  add(new DiceButton()).right().row()
  add("Dice result: ").row()
  add("Question:").row()
  (0 until 4) foreach { qId =>
    val answerLbl = add(s"- Answer $qId").center()
    if (qId == 3) {
      answerLbl.padBottom(15F)
    }

    answerLbl.row()
  }
  add("Type in your choice:").padRight(10F)
  add(new AnswerDropdown())

  setBackground("default-window")
}
