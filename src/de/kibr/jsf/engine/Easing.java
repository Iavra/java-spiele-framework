package de.kibr.jsf.engine;

@FunctionalInterface
public interface Easing {
    double ease(double k);

    Easing LINEAR = k -> k;

    Easing QUAD_IN = k -> Math.pow(k, 2);
    Easing QUAD_OUT = k -> -(Math.pow((k - 1), 2) - 1);
    Easing QUAD_IN_OUT = k -> {
        if ((k /= 0.5) < 1)
            return 0.5 * Math.pow(k, 2);
        return -0.5 * ((k -= 2) * k - 2);
    };

    Easing CUBIC_IN = k -> Math.pow(k, 3);
    Easing CUBIC_OUT = k -> (Math.pow((k - 1), 3) + 1);
    Easing CUBIC_IN_OUT = k -> {
        if ((k /= 0.5) < 1)
            return 0.5 * Math.pow(k, 3);
        return 0.5 * (Math.pow((k - 2), 3) + 2);
    };

    Easing QUART_IN = k -> Math.pow(k, 4);
    Easing QUART_OUT = k -> -(Math.pow((k - 1), 4) - 1);
    Easing QUART_IN_OUT = k -> {
        if ((k /= 0.5) < 1)
            return 0.5 * Math.pow(k, 4);
        return -0.5 * ((k -= 2) * Math.pow(k, 3) - 2);
    };

    Easing SINE_IN = k -> -Math.cos(k * (Math.PI / 2)) + 1;
    Easing SINE_OUT = k -> Math.sin(k * (Math.PI / 2));
    Easing SINE_IN_OUT = k -> (-0.5 * (Math.cos(Math.PI * k) - 1));

    Easing EXPO_IN = k -> (k == 0) ? 0 : Math.pow(2, 10 * (k - 1));
    Easing EXPO_OUT = k -> (k == 1) ? 1 : -Math.pow(2, -10 * k) + 1;
    Easing EXPO_IN_OUT = k -> {
        if (k == 0) return 0;
        if (k == 1) return 1;
        if ((k /= 0.5) < 1)
            return 0.5 * Math.pow(2, 10 * (k - 1));
        return 0.5 * (-Math.pow(2, -10 * --k) + 2);
    };

    Easing CIRC_IN = k -> -(Math.sqrt(1 - (k * k)) - 1);
    Easing CIRC_OUT = k -> Math.sqrt(1 - Math.pow((k - 1), 2));
    Easing CIRC_IN_OUT = k -> {
        if ((k /= 0.5) < 1)
            return -0.5 * (Math.sqrt(1 - k * k) - 1);
        return 0.5 * (Math.sqrt(1 - (k -= 2) * k) + 1);
    };

    Easing BACK_IN = k -> {
        double s = 1.70158;
        return k * k * ((s + 1) * k - s);
    };
    Easing BACK_OUT = k -> {
        double s = 1.70158;
        return (k = k - 1) * k * ((s + 1) * k + s) + 1;
    };
    Easing BACK_IN_OUT = k -> {
        double s = 1.70158;
        if ((k /= 0.5) < 1)
            return 0.5 * (k * k * (((s *= (1.525)) + 1) * k - s));
        return 0.5 * ((k -= 2) * k * (((s *= (1.525)) + 1) * k + s) + 2);
    };
}
