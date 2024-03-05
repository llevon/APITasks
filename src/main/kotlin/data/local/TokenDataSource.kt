package org.example.data.local

import java.util.prefs.Preferences

class TokenDataSource {
   private val preferences = Preferences.userRoot()

   fun setToken(token:String)
   {
      preferences.put("my_token", token)
   }

   fun getToken(): String
   {
      return preferences.get("my_token","")
   }
}