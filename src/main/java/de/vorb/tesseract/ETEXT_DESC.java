package de.vorb.tesseract;

import org.bridj.BridJ;
import org.bridj.Callback;
import org.bridj.Pointer;
import org.bridj.ann.Field;
import org.bridj.cpp.CPPObject;

/**
 * This file was autogenerated by <a
 * href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a
 * href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few
 * opensource projects.</a>.<br>
 * For help, please visit <a
 * href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a
 * href="http://bridj.googlecode.com/">BridJ</a> .
 */
public class ETEXT_DESC extends CPPObject {
    static {
        BridJ.register();
    }

    public static abstract class CANCEL_FUNC extends Callback<CANCEL_FUNC> {
        public abstract boolean apply(Pointer<?> cancel_this, int words);
    };

    public static native boolean NearlyEqual(LibTess.T x, LibTess.T y,
            LibTess.T tolerance);

    /** chars in this buffer(0) */
    @Field(0)
    public short count() {
        return this.io.getShortField(this, 0);
    }

    /** chars in this buffer(0) */
    @Field(0)
    public ETEXT_DESC count(short count) {
        this.io.setShortField(this, 0, count);
        return this;
    }

    /** percent complete increasing (0-100) */
    @Field(1)
    public short progress() {
        return this.io.getShortField(this, 1);
    }

    /** percent complete increasing (0-100) */
    @Field(1)
    public ETEXT_DESC progress(short progress) {
        this.io.setShortField(this, 1, progress);
        return this;
    }

    @Field(2)
    public byte more_to_come() {
        return this.io.getByteField(this, 2);
    }

    @Field(3)
    public boolean ocr_alive() {
        return this.io.getByteField(this, 3) != 0;
    }

    @Field(3)
    public void ocr_alive(boolean ocr_alive) {
        this.io.setByteField(this, 3, (byte) (ocr_alive ? 1 : 0));
    }

    @Field(4)
    public byte err_code() {
        return this.io.getByteField(this, 4);
    }

    /** returns true to cancel */
    @Field(5)
    public Pointer<CANCEL_FUNC> cancel() {
        synchronized (this) {
            return this.io.getPointerField(this, 5);
        }
    }

    /** returns true to cancel */
    @Field(5)
    public ETEXT_DESC cancel(Pointer<CANCEL_FUNC> cancel) {
        this.io.setPointerField(this, 5, cancel);
        return this;
    }

    /** this or other data for cancel */
    @Field(6)
    public Pointer<?> cancel_this() {
        return this.io.getPointerField(this, 6);
    }

    /** this or other data for cancel */
    @Field(6)
    public ETEXT_DESC cancel_this(Pointer<?> cancel_this) {
        this.io.setPointerField(this, 6, cancel_this);
        return this;
    }

    @Field(7)
    public timeval end_time() {
        return this.io.getNativeObjectField(this, 7);
    }

    /**
     * Conversion Error : EANYCODE_CHAR[1] (failed to convert type to Java
     * (undefined type))
     */
    public native void set_deadline_msecs(int deadline_msecs);

    public native boolean deadline_exceeded();
}
