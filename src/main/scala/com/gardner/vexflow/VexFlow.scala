package com.gardner.vexflow

import scala.scalajs.js
import scala.scalajs.js.annotation._

import org.scalajs.dom.raw.HTMLElement

// See the following pages:
// https://www.scala-js.org/doc/interoperability/facade-types.html
// http://stackoverflow.com/questions/28069561/dynamic-calls-to-javascript-in-scala-js

@js.native
@JSName("Vex.Flow.CanvasContext")
class VFCanvasContext extends js.Object {

}

@js.native
@JSName("Vex.Flow.Renderer")
class VFRenderer(canvas: HTMLElement, backendIndex: Int) extends js.Object {
  def getContext(): VFCanvasContext = js.native
}

@js.native
@JSName("Vex.Flow.Stave")
class VFStave(x: Int, y: Int, width: Int) extends js.Object {
  def addClef(name: String): this.type = js.native
  def addTimeSignature(timeSpec: String, padding: Int = 15): this.type = js.native
  def setContext(c: VFCanvasContext): this.type = js.native
  def draw(): this.type = js.native
}

@ScalaJSDefined
trait VFNote extends js.Object

@js.native
@JSName("Vex.Flow.StaveNote")
class VFStaveNote(args: js.Dictionary[Object]) extends VFNote

@js.native
@JSName("Vex.Flow.BarNote")
class VFBarNote() extends VFNote

@js.native
@JSName("Vex.Flow.TimeSignature")
class VFTimeSignature(timeSpec: String, padding: Int = 15) extends js.Object

@js.native
@JSName("Vex.Flow.Voice")
class VFVoice(args: js.Dictionary[Int]) extends js.Object {
  def addTickables(notes: js.Array[VFNote]): Unit = js.native
  def draw(context: VFCanvasContext, stave: VFStave): Unit = js.native
}

@js.native
@JSName("Vex.Flow.Formatter")
class VFFormatter extends js.Object {
  def joinVoices(voices: js.Array[VFVoice]): this.type = js.native
  def format(voices: js.Array[VFVoice], width: Int): this.type = js.native
}
