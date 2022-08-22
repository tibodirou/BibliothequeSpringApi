import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuteurDetailsComponent } from './auteur-details/auteur-details.component';
import { HomeComponent } from './home/home.component';
import { LivreDetailsComponent } from './livre-details/livre-details.component';
import { LivreFormComponent } from './livre-form/livre-form.component';
import { LivreModifierComponent } from './livre-modifier/livre-modifier.component';
import { LivreTableComponent } from './livre-table/livre-table.component';

const routes: Routes = [
  {path:'details/:id', component :LivreDetailsComponent},
  {path:'auteur/:id', component :AuteurDetailsComponent},
  {path:'Bibliotheque', component : LivreTableComponent},
  {path:'Ajout', component : LivreFormComponent},
  {path: '', component : HomeComponent},
  {path:'Modify/:id', component : LivreModifierComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
