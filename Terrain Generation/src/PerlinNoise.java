import java.util.Random;

public class PerlinNoise {
    int length;

    Vector3[] coordinates;

    public PerlinNoise(int length) {
        this.length = length;
        coordinates = new Vector3[length*length];

        int id = 0;

        for (int x = 0; x < length; x++) {
            for (int z = 0; z < length; z++) {
                coordinates[id] = new Vector3(x, 0, z);
                id++;
            }
        }
    }

    Vector3[] generateCoordinates(float amplitude, float frequency, int layers) {
        for (int i = 0; i < coordinates.length; i++) {
            for (int layer = 0; layer < layers; layer++) {
                Vector3 origin = coordinates[i];
                Vector3 toFocus = coordinates[i];

                int x = origin.x;
                int z = origin.z;
                int offsetReach = 2;

                Random rx = new Random(), rz = new Random();

                int xOffset = rx.nextInt(offsetReach*offsetReach)-offsetReach+1;
                int zOffset = rz.nextInt(offsetReach*offsetReach)-offsetReach+1;
                int newX = x*xOffset, newZ = z*zOffset;
                int id = 0;

                for (int j = 0; j < coordinates.length; j++) {
                    if (coordinates[j].x == newX && coordinates[j].z == newZ) {
                        toFocus = coordinates[j];
                        id = j;
                        break;
                    }
                }

                int min = 0, max = 10;

                Random ry = new Random();

                float yOffset = (ry.nextInt(min+max)+7-min)*amplitude*frequency;

                toFocus = new Vector3(toFocus.x, origin.y + yOffset, toFocus.z);
                coordinates[id] = new Vector3(coordinates[i].x, toFocus.y + coordinates[i].y, coordinates[i].z);
            }
        }

        return coordinates;
    }
}
