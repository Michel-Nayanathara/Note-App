package com.example.myapplicationnewtaskmanagement;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.jvm.internal.Intrinsics;


public final class Note {
    private final int id;
    @NotNull
    private final String title;
    @NotNull
    private final String content;

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public Note(int id, @NotNull String title, @NotNull String content) {

        super();
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public final int component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.content;
    }

    @NotNull
    public final Note copy(int id, @NotNull String title, @NotNull String content) {

        return new Note(id, title, content);
    }

    // $FF: synthetic method
    public static Note copy$default(Note var0, int var1, String var2, String var3, int var4, Object var5) {
        if ((var4 & 1) != 0) {
            var1 = var0.id;
        }

        if ((var4 & 2) != 0) {
            var2 = var0.title;
        }

        if ((var4 & 4) != 0) {
            var3 = var0.content;
        }

        return var0.copy(var1, var2, var3);
    }

    @NotNull
    public String toString() {
        return "Note(id=" + this.id + ", title=" + this.title + ", content=" + this.content + ")";
    }

    public int hashCode() {
        int var10000 = Integer.hashCode(this.id) * 31;
        String var10001 = this.title;
        var10000 = (var10000 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
        var10001 = this.content;
        return var10000 + (var10001 != null ? var10001.hashCode() : 0);
    }

    public boolean equals(@Nullable Object var1) {
        if (this != var1) {
            if (var1 instanceof Note) {
                Note var2 = (Note)var1;
                if (this.id == var2.id && Intrinsics.areEqual(this.title, var2.title) && Intrinsics.areEqual(this.content, var2.content)) {
                    return true;
                }
            }

            return false;
        } else {
            return true;
        }
    }
}
