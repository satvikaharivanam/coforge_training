import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { Child1 } from './child1/child1';
import { Child2 } from './child2/child2';

@NgModule({
  declarations: [
    // registers all components here. loads everything in one shot. (same as IOC...kind of)
    App,
    Child1,
    Child2,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [provideBrowserGlobalErrorListeners()],
  bootstrap: [App], // to specify the root component.
})
export class AppModule {}
