package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.lang.ref.Reference;
import java.util.Random;

public class CustomParticle extends Particle {

    public static TextureAtlasSprite largeStarRL2 = null;
    public static TextureAtlasSprite largeStarRL1 = null;

    private float fireScale;

    private float maxage;

    private Entity entity;


    public CustomParticle(World worldIn, double x, double y, double z, double velocityX, double velocityY, double velocityZ){

        super(worldIn, x, y, z, velocityX, velocityY, velocityZ);

        this.particleAlpha = 0.99F;
        this.particleMaxAge = 100;
        this.particleAge = 0;

        fireScale=this.particleScale=25;
        maxage=particleMaxAge;
//        System.out.println(largeStarRL2);




        setParticleTexture(largeStarRL2);
    }

    @Override
    public void renderParticle(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ)
    {
//        this.partialTicks=partialTicks;
//        float f = ((float)this.particleAge + partialTicks) / (float)this.particleMaxAge;
//        this.particleScale = this.fireScale * (1.0F - f * f * 0.5F);
//        super.renderParticle(buffer, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
        this.entity=entityIn;
        customRender(buffer, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }

    public void customRender(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ)
    {
        float f = (float)this.particleTextureIndexX / 16.0F;
        float f1 = f + 0.0624375F;
        float f2 = (float)this.particleTextureIndexY / 16.0F;
        float f3 = f2 + 0.0624375F;
        float f4 = 0.1F * this.particleScale;

        if (this.particleTexture != null)
        {
            f=particleTexture.getMinU();
            f1=particleTexture.getMaxU();
            f2=particleTexture.getMinV();
            f3=particleTexture.getMaxV();
        }
//        System.out.println("render.....");
//        System.out.println("prex"+prevPosX);
//        System.out.println("prey"+prevPosY);
//        System.out.println("prez"+prevPosZ);
//        System.out.println("montionx"+motionX);
//        System.out.println("montiony"+motionY);
//        System.out.println("montionz"+motionZ);
//        System.out.println("x:"+posX);
//        System.out.println("y:"+posY);
//        System.out.println("z:"+posZ);
        try {
//            interpPosX = prevPosX = posX = entity.posX;
//            interpPosY = prevPosY = posY = entity.posY + 0.2;
//            interpPosZ = prevPosZ = posZ = entity.posZ;
//            interpPosX = prevPosX = posX ;
        }catch (Exception e){
            System.out.println(e);
            System.out.println(entity);
            System.out.println(entity.posX);
            this.setExpired();
        }
        float f5 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)partialTicks - interpPosX);
        float f6 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)partialTicks - interpPosY);
        float f7 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)partialTicks - interpPosZ);
//        System.out.println("f5"+f5);
//        System.out.println("f6"+f6);
//        System.out.println("f7"+f7);
//        System.out.println("ownerrender.....");
        int i = this.getBrightnessForRender(partialTicks);
        int j = i >> 16 & 65535;
        int k = i & 65535;
        Vec3d[] avec3d = new Vec3d[] {new Vec3d((double)(-rotationX * f4 - rotationXY * f4), (double)(-rotationZ * f4), (double)(-rotationYZ * f4 - rotationXZ * f4)), new Vec3d((double)(-rotationX * f4 + rotationXY * f4), (double)(rotationZ * f4), (double)(-rotationYZ * f4 + rotationXZ * f4)), new Vec3d((double)(rotationX * f4 + rotationXY * f4), (double)(rotationZ * f4), (double)(rotationYZ * f4 + rotationXZ * f4)), new Vec3d((double)(rotationX * f4 - rotationXY * f4), (double)(-rotationZ * f4), (double)(rotationYZ * f4 - rotationXZ * f4))};

//        if (this.particleAngle != 0.0F)
//        {
//            float f8 = this.particleAngle + (this.particleAngle - this.prevParticleAngle) * partialTicks;
//            float f9 = MathHelper.cos(f8 * 0.5F);
//            float f10 = MathHelper.sin(f8 * 0.5F) * (float)cameraViewDir.x;
//            float f11 = MathHelper.sin(f8 * 0.5F) * (float)cameraViewDir.y;
//            float f12 = MathHelper.sin(f8 * 0.5F) * (float)cameraViewDir.z;
//            Vec3d vec3d = new Vec3d((double)f10, (double)f11, (double)f12);
//
//            for (int l = 0; l < 4; ++l)
//            {
//                avec3d[l] = vec3d.scale(2.0D * avec3d[l].dotProduct(vec3d)).add(avec3d[l].scale((double)(f9 * f9) - vec3d.dotProduct(vec3d))).add(vec3d.crossProduct(avec3d[l]).scale((double)(2.0F * f9)));
//            }
//        }

//        buffer.pos((double)f5 + avec3d[0].x, (double)f6 + avec3d[0].y, (double)f7 + avec3d[0].z).tex((double)f1, (double)f3).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j, k).endVertex();
//        buffer.pos((double)f5 + avec3d[1].x, (double)f6 + avec3d[1].y, (double)f7 + avec3d[1].z).tex((double)f1, (double)f2).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j, k).endVertex();
//        buffer.pos((double)f5 + avec3d[2].x, (double)f6 + avec3d[2].y, (double)f7 + avec3d[2].z).tex((double)f, (double)f2).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j, k).endVertex();
//        buffer.pos((double)f5 + avec3d[3].x, (double)f6 + avec3d[3].y, (double)f7 + avec3d[3].z).tex((double)f, (double)f3).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j, k).endVertex();
        System.out.println("--------------------");
        System.out.println(avec3d[0].x+";"+avec3d[1].x+";"+avec3d[2].x+";"+avec3d[3].x+";");
        System.out.println(avec3d[0].y+";"+avec3d[1].y+";"+avec3d[2].y+";"+avec3d[3].y+";");
        System.out.println(avec3d[0].z+";"+avec3d[1].z+";"+avec3d[2].z+";"+avec3d[3].z+";");
        System.out.println("--------------------");
//          buffer.pos((double)f5 + 0, (double)f6 + avec3d[0].y, (double)f7 + 0).tex((double)f1, (double)f3).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j, k).endVertex();
//          buffer.pos((double)f5 + 0, (double)f6 + avec3d[1].y, (double)f7 + 0).tex((double)f1, (double)f2).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j, k).endVertex();
//          buffer.pos((double)f5 + 0, (double)f6 + avec3d[2].y, (double)f7 + 0).tex((double)f, (double)f2).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j, k).endVertex();
//          buffer.pos((double)f5 + 0, (double)f6 + avec3d[3].y, (double)f7 + 0).tex((double)f, (double)f3).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j, k).endVertex();

        buffer.pos((double)f5 + avec3d[0].x, (double)f6 +0, (double)f7 + avec3d[0].z).tex((double)f1, (double)f3).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j, k).endVertex();
        buffer.pos((double)f5 + avec3d[1].x, (double)f6 + 3, (double)f7 + avec3d[1].z).tex((double)f1, (double)f2).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j, k).endVertex();
        buffer.pos((double)f5 + avec3d[2].x, (double)f6 + 5, (double)f7 + avec3d[2].z).tex((double)f, (double)f2).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j, k).endVertex();
        buffer.pos((double)f5 + avec3d[3].x, (double)f6 + 0, (double)f7 + avec3d[3].z).tex((double)f, (double)f3).color(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha).lightmap(j, k).endVertex();

    }


    @Override
    public int getFXLayer() {

        return 1;

    }

    @Override
    public int getBrightnessForRender(float partialTick) {

        return 0xf000f0;

    }


    @Override
    public void onUpdate(){
//        System.out.println("update...");
//        particleAlpha=(particleMaxAge/maxage);//

//        move(0,0.03,0);
//        System.out.println("prex"+prevPosX);
//        System.out.println("prey"+prevPosY);
//        System.out.println("prez"+prevPosZ);
//        System.out.println("montionx"+motionX);
//        System.out.println("montiony"+motionY);
//        System.out.println("montionz"+motionZ);
//        System.out.println("x:"+posX);
//        System.out.println("y:"+posY);
//        System.out.println("z:"+posZ);
//        System.out.println("updateover......");

//        System.out.println("particleAlpha "+particleAlpha);
//        System.out.println("particleMaxAge "+particleMaxAge);
//        System.out.println("maxage "+maxage);
//        move(0.1,0.1,0.1);
//        Random ran = new Random();
//        int num = ran.nextInt(20);
//
//        if (particleScale > 2){
//            particleScale = 1;
//        }
//
//        switch(num){
//
//            case 1:
//                particleScale = particleScale * (float)1.1;
//                break;
//
//            case 4:
//                particleScale = particleScale * (float)1.2;
//                break;
//
//            case 8:
//                particleScale = particleScale * (float)0.9;
//                break;
//
//            case 12:
//                particleScale = particleScale * (float)0.8;
//                break;
//
//            case 16:
//                particleScale = 1;
//                break;
//
//        }
//
        if (this.particleMaxAge-- <= 0) {
            this.setExpired();
        }

    }

}