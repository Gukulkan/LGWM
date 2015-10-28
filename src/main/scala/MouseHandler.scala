package com.mylwjgl.handlers

import org.lwjgl.glfw.GLFWCursorPosCallback

/**
 * Created by User on 9/25/2015.
 */
class MouseHandler extends GLFWCursorPosCallback {
  override def invoke(window: Long, xPosition: Double, yPosition: Double): Unit = {
    println(s"This x position $xPosition and this is y position $yPosition")
  }
}
