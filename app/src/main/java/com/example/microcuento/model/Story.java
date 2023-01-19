package com.example.microcuento.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

/**
 *
 * La clase Story representa los datos que vamos a manejar en la aplicación.
 * Extendiede de parselable ya que vamos a pasar información  de una activity a otro
 */
public class Story implements Parcelable {

    private String title;
    private String advance;
    private String story;

    public Story(String title, String advance, String story) {
        this.title = title;
        this.advance = advance;
        this.story = story;
    }

    /**
     *
     * @param in Constructor que recibe un objeto de tipo Parcel
     *           (Método de la interfaz Parcelable)
     */
    protected Story(Parcel in) {
        title = in.readString();
        advance = in.readString();
        story = in.readString();
    }

    /**
     *
     * @return Devuelve un objeto de tipo Parcel
     * (Método de la interfaz Parcelable)
     */
    public static final Creator<Story> CREATOR = new Creator<Story>() {
        @Override
        public Story createFromParcel(Parcel in) {
            return new Story(in);
        }

        @Override
        public Story[] newArray(int size) {
            return new Story[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getAdvance() {
        return advance;
    }

    public String getStory() {
        return story;
    }

    @Override
    public String toString() {
        return "Cuento{" +
                "title='" + title + '\'' +
                ", advance='" + advance + '\'' +
                ", story='" + story + '\'' +
                '}';
    }

    /**
     *
     * @return Devuelve un entero que representa el tamaño del objeto
     * (Método de la interfaz Parcelable)
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     *
     * @param dest The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     * May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     *              (Método de la interfaz Parcelable)
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(advance);
        dest.writeString(story);
    }
}
