package com.mylwjgl

import com.mylwjgl.gameEngine.GameObject
import org.lwjgl.Sys
import org.lwjgl.glfw.GLFW._
import org.lwjgl.opengl.GL11._
import org.lwjgl.opengl.GLContext

object Main {

  var(width,hight) = (800, 600)
  var running = false
  var window = 0l
  var paddle:GameObject = null

  def init ={
    this.running = true

    if(glfwInit() != GL_TRUE){
      println("GLFW initialization failed!")
    }

    glfwWindowHint(GLFW_RESIZABLE, GL_TRUE)

    this.window = glfwCreateWindow(width,hight, "My Window", 0l, 0l)

    if(window == null){
      println("Could not create window!")
    }

    val vinmode = glfwGetVideoMode(glfwGetPrimaryMonitor())

    glfwSetWindowPos(window, 100, 100)

    glfwMakeContextCurrent(window)

    glfwShowWindow(window)

    GLContext.createFromCurrent()
    System.out.println("OpenGL is " + glGetString(GL_VERSION) + "!")

    paddle = {
      val tmp = new GameObject
      tmp.apply(1)
      tmp
    }

  }

  def render ={
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
    glClearColor(1.0f,1.0f,1.0f,1.0f)

    paddle.draw

    glfwSwapBuffers(window)
  }

  def update = {
    glfwPollEvents()
  }

  def run: Unit = {
    init
    while (running){
      update
      render
      if(glfwWindowShouldClose(window) == GL_TRUE){
        running = false
      }
    }
  }

  def main (args: Array[String]) {
    System.out.println("Hello LWJGL " + Sys.getVersion + "!")
    run
  }


}
