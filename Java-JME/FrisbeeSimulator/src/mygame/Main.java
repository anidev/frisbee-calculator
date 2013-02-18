package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Cylinder;

/**
 * test
 * @author normenhansen
 */
public class Main extends SimpleApplication {
    private Geometry geom;
    private Frisbee frisbee;
    private double maxHeight;
    private boolean showX=false;
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Vector3f camPos=cam.getLocation();
        camPos.setZ(camPos.getZ()+40);
        camPos.setX(camPos.getX()+20);
        cam.setLocation(camPos);
        double angle=7.91265; // degrees
        double v0=14; // m/s
        frisbee=new Frisbee(v0,angle,Frisbee.MASS);
        Box mesh = new Box(Vector3f.ZERO, 1, 0.1f, 1);
//        Cylinder mesh = new Cylinder(20,50,3,1,true);
        geom = new Geometry("Frisbee", mesh);
        geom.setLocalTranslation(Vector3f.ZERO);
        geom.setLocalRotation(new Quaternion().fromAngleAxis((float)(Math.PI/2),Vector3f.UNIT_X));
        geom.setLocalRotation(new Quaternion().fromAngleAxis((float)torad(angle),Vector3f.UNIT_Z));

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);

        rootNode.attachChild(geom);
    }

    @Override
    public void simpleUpdate(float tpf) {
        if(frisbee.getY()<0) {
            if(!showX) {
                System.out.println(maxHeight);
                System.out.println(frisbee.getX());
                showX=true;
            }
            return;
        }
        frisbee.step();
        if(frisbee.getY()>maxHeight) {
            maxHeight=frisbee.getY();
        }
    }

    @Override
    public void simpleRender(RenderManager rm) {
        double scale=1;
        Vector3f pos=Vector3f.ZERO;
        pos.setX((float)(frisbee.getX()*scale));
        pos.setY((float)(frisbee.getY()*scale));
//        System.out.println(frisbee.getX());
        geom.setLocalTranslation(pos);
/*        if(frisbee.getY()<0) {
            System.exit(0);
        }*/
    }
    private double torad(double deg) {
        return deg*(Math.PI/180);
    }
}
