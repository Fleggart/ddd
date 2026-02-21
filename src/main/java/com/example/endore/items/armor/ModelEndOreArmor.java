package com.example.endore.items.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * 末地矿石3D盔甲模型
 * 使用BlockBench导出后修改
 */
public class ModelEndOreArmor extends ModelBiped {
    
    // 模型部件 - 这些变量名根据BlockBench生成的代码调整
    public final ModelRenderer bone;
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer leftArm;
    private final ModelRenderer rightArm;
    private final ModelRenderer leftLeg;
    private final ModelRenderer rightLeg;

    public ModelEndOreArmor() {
        textureWidth = 64;
        textureHeight = 64;

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 24.0F, 0.0F);
        
        // 头盔部件
        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, -24.0F, 0.0F);
        bone.addChild(head);
        head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F, false));
        
        // 胸甲部件
        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, -24.0F, 0.0F);
        bone.addChild(body);
        body.cubeList.add(new ModelBox(body, 16, 16, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F, false));
        
        // 左臂
        leftArm = new ModelRenderer(this);
        leftArm.setRotationPoint(5.0F, -22.0F, 0.0F);
        bone.addChild(leftArm);
        leftArm.cubeList.add(new ModelBox(leftArm, 32, 48, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F, true));
        
        // 右臂
        rightArm = new ModelRenderer(this);
        rightArm.setRotationPoint(-5.0F, -22.0F, 0.0F);
        bone.addChild(rightArm);
        rightArm.cubeList.add(new ModelBox(rightArm, 40, 16, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F, false));
        
        // 左腿
        leftLeg = new ModelRenderer(this);
        leftLeg.setRotationPoint(1.9F, -12.0F, 0.0F);
        bone.addChild(leftLeg);
        leftLeg.cubeList.add(new ModelBox(leftLeg, 16, 48, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F, true));
        
        // 右腿
        rightLeg = new ModelRenderer(this);
        rightLeg.setRotationPoint(-1.9F, -12.0F, 0.0F);
        bone.addChild(rightLeg);
        rightLeg.cubeList.add(new ModelBox(rightLeg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F, false));

        // 将模型绑定到身体骨骼 - 关键步骤[citation:2]
        this.bipedHead.addChild(head);
        this.bipedBody.addChild(body);
        this.bipedLeftArm.addChild(leftArm);
        this.bipedRightArm.addChild(rightArm);
        this.bipedLeftLeg.addChild(leftLeg);
        this.bipedRightLeg.addChild(rightLeg);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, 
                       float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        // 同步玩家姿态[citation:1]
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, 
                               netHeadYaw, headPitch, scale, entity);
        
        // 渲染模型
        this.bipedHead.render(scale);
        this.bipedBody.render(scale);
        this.bipedLeftArm.render(scale);
        this.bipedRightArm.render(scale);
        this.bipedLeftLeg.render(scale);
        this.bipedRightLeg.render(scale);
    }

    /**
     * 设置部件的旋转角度
     */
    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
