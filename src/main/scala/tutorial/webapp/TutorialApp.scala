package tutorial.webapp

import scala.scalajs.js
import scala.scalajs.js.JSConverters._

import com.gardner.music.core._
import com.gardner.vexflow._

import org.scalajs.jquery.jQuery

object TutorialApp extends js.JSApp {

  def setupUI() {
    jQuery("""<button type="button">Click me!</button>""")
      .click(addClickedMessage _)
      .appendTo(jQuery("body"))
    appendPar("body", "Hello world!")
    jQuery("""<canvas width=700 height=100"></canvas>""")
      .appendTo(jQuery("body"))
    val canvas = jQuery("canvas")(0)
    val renderer = new VFRenderer(canvas, 1)
    val context = renderer.getContext()
    val staveWidth = 500
    val stave = new VFStave(0, 0, staveWidth)
    stave.addClef("treble").addTimeSignature("4/4").setContext(context).draw()
    println("Done drawing stave")

    println("Creating notes")
    val notes = js.Array(
      new VFStaveNote(Map("keys" -> js.Array("c/4"), "duration" -> "q").toJSDictionary),
      new VFStaveNote(Map("keys" -> js.Array("d/4"), "duration" -> "q").toJSDictionary),
      new VFStaveNote(Map("keys" -> js.Array("b/4"), "duration" -> "qr").toJSDictionary),
      new VFStaveNote(Map("keys" -> js.Array("c/4", "e/4", "g/4"), "duration" -> "q").toJSDictionary),
      new VFBarNote,
      new VFStaveNote(Map("keys" -> js.Array("c/4"), "duration" -> "q").toJSDictionary),
      new VFStaveNote(Map("keys" -> js.Array("d/4"), "duration" -> "q").toJSDictionary),
      new VFStaveNote(Map("keys" -> js.Array("b/4"), "duration" -> "qr").toJSDictionary),
      new VFStaveNote(Map("keys" -> js.Array("c/4", "e/4", "g/4"), "duration" -> "q").toJSDictionary)
    )

    println("Creating voice")
    val voice = new VFVoice(Map("num_beats" -> 8, "beat_value" -> 4, "resolution" -> 16384).toJSDictionary)
    println("Adding notes to voice")
    voice.addTickables(notes)
    println("Creating formatter")
    val formatter = new VFFormatter().joinVoices(js.Array(voice)).format(js.Array(voice), staveWidth-50)
    println("Drawing the voice")
    voice.draw(context, stave)
    appendPar("body", "Should see notes now")
  }

  def main() {
    jQuery(setupUI _)
  }

  def addClickedMessage() {
    appendPar("body", "You clicked the button!")
  }

  def appendPar(selector: String, text: String) {
    jQuery(selector).append(s"<p>$text</p>")
  }
}
