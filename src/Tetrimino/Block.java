package Tetrimino;

public class Block
{
   private int posX; // Position en x du block
   private int posY; // Position en y du block
   private int textureImage; // Texture du bock (couleur)
   
   public Block(int posX, int posY, int textureImage)
   {
      this.posX = posX;
      this.posY = posY;
      this.textureImage = textureImage;
   }
   
   
   /** GETTEURS ET SETTEURS **/
   
   /////////////////////////////////////////////////////////////
   public int getPosX()
   {
      return posX;
   }
   public void setPosX(int posX)
   {
      this.posX = posX;
   }
   /////////////////////////////////////////////////////////////
   
   
   /////////////////////////////////////////////////////////////
   public int getPosY()
   {
      return posY;
   }
   public void setPosY(int posY)
   {
      this.posY = posY;
   }
   /////////////////////////////////////////////////////////////
   
   
   /////////////////////////////////////////////////////////////
   public int getTextureImage()
   {
      return textureImage;
   }
   public void setTextureImage(int textureImage)
   {
      this.textureImage = textureImage;
   } 
   /////////////////////////////////////////////////////////////
   
   /** METHODE QUI PERMET DE MODIFIER LES VALEURS DE X ET Y **/
   public void setXY(int x, int y) {
	   this.posX = x;
	   this.posY = y;
   }

}