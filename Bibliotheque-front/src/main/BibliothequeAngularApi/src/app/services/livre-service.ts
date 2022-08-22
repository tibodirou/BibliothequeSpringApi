import { HttpClient } from "@angular/common/http";
import { Inject, Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { Livre } from "../livre";

@Injectable({providedIn: 'root'})
export class LivreService {
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient){}

    public getAuteurLivres(name: string): Observable<Livre[]>  {
        return this.http.get<Livre[]>(`${this.apiServerUrl}/Bibliotheque/api/auteur/${name}`);
    }

    public getLivres(): Observable<Livre[]> {
        return this.http.get<Livre[]>(`${this.apiServerUrl}/Bibliotheque/api/livre`);
    }

    public addLivres(livre : Livre): Observable<Livre> {
        return this.http.post<Livre>(`${this.apiServerUrl}/Bibliotheque/api/livre`, livre);
    }

    public getLivreDetails(id: number): Observable<Livre>  {
        return this.http.get<Livre>(`${this.apiServerUrl}/Bibliotheque/api/livre/${id}`);
    }

    public deleteLivre(id: number): Observable<String> {
        return this.http.delete<String>(`${this.apiServerUrl}/Bibliotheque/api/livre/${id}`);
    }

    public updateLivre(livre : Livre): Observable<Livre> {
        return this.http.put<Livre>(`${this.apiServerUrl}/Bibliotheque/api/livre/`, livre);
    }
}

//finir ajout de livres