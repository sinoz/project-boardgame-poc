package rotbord.gdx.assets

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.{SkinLoader, TextureLoader}
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import rotbord.gdx.assets.impl.{SkinFileHandleResolver, TextureFileHandleResolver}

object GameAssets {
  private val assetsManager = new AssetManager()

  def fetch[T](fileName: String, classType: Class[T]): T = {
    if (!assetsManager.isLoaded(fileName, classType)) {
      assetsManager.load(fileName, classType)
      assetsManager.finishLoading()
    }

    assetsManager.get(fileName, classType)
  }

  assetsManager.setLoader(classOf[Texture], new TextureLoader(TextureFileHandleResolver))
  assetsManager.setLoader(classOf[Skin], new SkinLoader(SkinFileHandleResolver))
}
