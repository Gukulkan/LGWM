package com.mylwjgl.gameEngine

import com.mylwjgl.graphicEngine.VertexArrayObject
import org.lwjgl.opengl.GL11._
import org.lwjgl.opengl.GL20._
import org.lwjgl.opengl.GL30._

class GameObject {
  var vaoId:Integer = 0
  val SIZE = 1.0f
  var count:Integer = 0

  val vertices = Array[Float](
    -0.25f, 0.25f, 0f,
    -0.25f, -0.25f, 0f,
    0.25f, -0.25f, 0f,
    0.25f, 0.25f, 0f
    )
  val indices = Array[Byte](0, 1, 2, 2, 3, 0)
  var vao:VertexArrayObject = null

  def apply( vaoId:Integer)={
    this.vaoId = vaoId
    this.count = indices.length
    this.vao = {
      val tmp = new VertexArrayObject
      tmp.apply(this.vertices,this.indices)
      tmp
    }
    this
  }

  def draw = {
    glBindVertexArray(this.vaoId)
    glEnableVertexAttribArray(0)
    glDrawElements(GL_TRIANGLES,count, GL_UNSIGNED_BYTE,0)
    glDisableVertexAttribArray(0)
    glBindVertexArray(0)
  }
}
