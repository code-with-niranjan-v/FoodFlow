package com.example.foodflow.di

import com.example.foodflow.firebase.FoodFirebaseDatabase
import com.example.foodflow.repository.FoodItemsRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {


    @Provides
    @Singleton
    fun provideFireBaseAuth(): FirebaseAuth = Firebase.auth

    @Provides
    @Singleton
    fun provideFireBaseStoreDb(): FirebaseFirestore = Firebase.firestore

    @Provides
    @Singleton
    fun provideFireBaseStorage(): FirebaseStorage = Firebase.storage

    @Provides
    @Singleton
    fun provideFoodFireBase(firebaseAuth: FirebaseAuth, firebaseFireStore: FirebaseFirestore, firebaseStorage: FirebaseStorage):FoodFirebaseDatabase = FoodFirebaseDatabase(firebaseAuth,firebaseFireStore,firebaseStorage)

    @Provides
    @Singleton
    fun provideItemsRepo(firebaseDatabase: FoodFirebaseDatabase):FoodItemsRepository = FoodItemsRepository(firebaseDatabase)

}