/* tslint:disable */
/* eslint-disable */
import { Auteur } from './auteur';
import { Collection } from './collection';
import { Editeur } from './editeur';
import { Illustrateur } from './illustrateur';

/**
 * un livre
 */
export interface Livre {

  /**
   * une collection
   */
  Collection?: Array<Collection>;
  auteur: Auteur;
  editeur?: Editeur;
  id: number;
  illustrateur?: Illustrateur;
}
