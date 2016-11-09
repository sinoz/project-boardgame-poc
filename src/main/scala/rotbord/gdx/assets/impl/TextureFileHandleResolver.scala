package rotbord.gdx.assets.impl

import java.io.File

import com.badlogic.gdx.assets.loaders.FileHandleResolver
import com.badlogic.gdx.files.FileHandle

object TextureFileHandleResolver extends FileHandleResolver {
  private val classLoader = getClass.getClassLoader

  override def resolve(fileName: String): FileHandle =
    new FileHandle(new File(classLoader.getResource("textures/" + fileName + ".png").toURI))
}
