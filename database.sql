PGDMP     -    (                 {            SnakeTheGame    15.1    15.1 
    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                        0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16396    SnakeTheGame    DATABASE     �   CREATE DATABASE "SnakeTheGame" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Polish_Poland.1250';
    DROP DATABASE "SnakeTheGame";
                postgres    false            �            1259    16397 	   GameUsers    TABLE     �   CREATE TABLE public."GameUsers" (
    "User_id" integer NOT NULL,
    "User_name" text,
    "User_password" text,
    "Group" text
);
    DROP TABLE public."GameUsers";
       public         heap    postgres    false            �            1259    16411    Games    TABLE     |   CREATE TABLE public."Games" (
    "Id_game" integer NOT NULL,
    "Id_user" integer NOT NULL,
    score integer NOT NULL
);
    DROP TABLE public."Games";
       public         heap    postgres    false            �          0    16397 	   GameUsers 
   TABLE DATA           W   COPY public."GameUsers" ("User_id", "User_name", "User_password", "Group") FROM stdin;
    public          postgres    false    214   �	       �          0    16411    Games 
   TABLE DATA           >   COPY public."Games" ("Id_game", "Id_user", score) FROM stdin;
    public          postgres    false    215   3
       i           2606    16403    GameUsers Users_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public."GameUsers"
    ADD CONSTRAINT "Users_pkey" PRIMARY KEY ("User_id");
 B   ALTER TABLE ONLY public."GameUsers" DROP CONSTRAINT "Users_pkey";
       public            postgres    false    214            k           2606    16415    Games gAMES_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public."Games"
    ADD CONSTRAINT "gAMES_pkey" PRIMARY KEY ("Id_game");
 >   ALTER TABLE ONLY public."Games" DROP CONSTRAINT "gAMES_pkey";
       public            postgres    false    215            �   w   x�E�;�0k������3��P�"��)4&d�!>}�*���y�I��B��:t��N�����M�)%� �t(=8Ņ_P�c����; D����kU�&�.�1�]���h�� ��*      �   �   x�=���0�s4L��������(�⓾1O�e׼�B��Ь�����=fлo��= /�:�d�����Il��xo�i��h�a5�1���V̈́u��Y�LU��:C?�Gկx�ο+?��V�[����h2~     